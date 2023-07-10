package com.beacon.model.order

import com.beacon.model.H2Config
import com.beacon.model.builders.TaskBuilder
import spock.lang.Shared
import spock.lang.Specification

class TaskSpec extends Specification {

    @Shared
    Task task;
    @Shared
    def tasks = new HashSet()

    def session = H2Config.getSession()

    def setupSpec() {
        task = TaskBuilder.create().withFirstName("Alex")
        .withLastName("Smith")
        .withEmail("test@test.com")
        .withPhoneNumber("+1111111111")
        .withCity("LA")
        .withStreet("Street")
        .withComment("Comment")
        .build()

        tasks.add(task)
    }

    def 'A: tasks contain this task'() {
        expect:
        tasks.contains(task)
    }

    def 'B: tasks contain task when persist then success'() {
        def transaction = session.beginTransaction()

        expect:
        task.getTaskId() == null

        when:
        session.persist(task)
        session.flush()
        transaction.commit()

        then:
        task.getTaskId() != null
        tasks.contains(task)
    }

    def 'C: tasks contain task when merge'() {
        def transaction = session.beginTransaction()
        task.setComment("new comment")

        expect:
        tasks.contains(task)

        when:
        Task mergedTask = session.merge(task)
        session.flush()
        transaction.commit()

        then:
        tasks.contains(mergedTask)
    }

    def 'D: tasks contain task when find'() {
        def transaction = session.beginTransaction()

        when:
        Task foundTask = session.find(Task, task.getTaskId())
        session.flush()
        transaction.commit()

        then:
        tasks.contains(foundTask)
    }

    def 'E: tasks contain task when detach'() {
        def transaction = session.beginTransaction()

        when:
        Task foundTask = session.find(Task, task.getTaskId())
        session.detach(foundTask)
        transaction.commit()

        then:
        tasks.contains(foundTask)
    }

    def 'F: tasks contain task when remove'() {
        def transaction = session.beginTransaction()

        when:
        Task foundTask = session.find(Task, task.getTaskId())
        session.remove(foundTask)
        session.flush()
        transaction.commit()

        then:
        tasks.contains(foundTask)
        tasks.remove(foundTask)
        !tasks.contains(foundTask)
    }
}
