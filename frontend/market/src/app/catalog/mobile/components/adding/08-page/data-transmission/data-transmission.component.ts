import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-data-transmission',
  templateUrl: './data-transmission.component.html',
  styleUrls: ['./data-transmission.component.css']
})
export class DataTransmissionComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        edge: [this.mobileFull?.edge ? this.mobileFull?.edge : false],
        hspa: [this.mobileFull?.hspa ? this.mobileFull?.hspa : false],
        hspaPlus: [this.mobileFull?.hspaPlus ? this.mobileFull?.hspaPlus : false],
        lte: [this.mobileFull?.lte ? this.mobileFull?.lte : false],
        fiveG: [this.mobileFull?.fiveG ? this.mobileFull?.fiveG : false]
      });
  }

  onNext() {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.saveToMobileFull();
    console.log(JSON.stringify(this.mobileFull, null, 2));
    this.page++;
    this.outputPage.emit(this.page);
  }

  onBack() {
    this.page--;
    this.outputPage.emit(this.page);
  }

  get controls(): { [p: string]: AbstractControl } {
    return this.form.controls;
  }

  private saveToMobileFull() {
    if (this.mobileFull != null) {
      this.mobileFull.edge = this.controls.edge.value;
      this.mobileFull.hspa = this.controls.hspa.value;
      this.mobileFull.hspaPlus = this.controls.hspaPlus.value;
      this.mobileFull.lte = this.controls.lte.value;
      this.mobileFull.fiveG = this.controls.fiveG.value;
    }
  }

}
