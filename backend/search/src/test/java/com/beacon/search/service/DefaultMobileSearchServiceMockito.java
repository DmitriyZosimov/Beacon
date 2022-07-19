package com.beacon.search.service;

import com.beacon.model.MobileDto;
import com.beacon.search.dao.MobileSearchDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultMobileSearchServiceMockito {

    @InjectMocks
    DefaultMobileSearchService service;

    @Mock
    MobileSearchDao dao;

    @Test
    public void testStringStripOfInputQuery_shouldCutUnnecessaryBlanksAndSpaces() {
        String query = "            first second                     third   ";

        when(dao.search(anyString())).thenAnswer(invocation -> {
            Object[] arguments = invocation.getArguments();
            Assertions.assertEquals(1, arguments.length);
            String argument = invocation.getArgument(0, String.class);
            Assertions.assertEquals("first second third", argument);
            return null;
        });
        service.search(query);
    }

    @Test
    public void testBlankCheckOfInputQuery_shouldReturnNull() {
        String query = "              ";
        List<MobileDto> list = service.search(query);
        Assertions.assertNull(list);
    }

    @Test
    public void testEmptyCheckOfInputQuery_shouldReturnNull() {
        String query = "";
        List<MobileDto> list = service.search(query);
        Assertions.assertNull(list);
    }
}
