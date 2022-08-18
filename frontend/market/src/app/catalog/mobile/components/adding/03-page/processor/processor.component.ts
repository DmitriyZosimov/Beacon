import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  chipsetModels = mobileProperties.chipsetModels;


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        chipsetModel: [this.mobileFull?.chipsetModel != null ? this.mobileFull?.chipsetModel : this.chipsetModels[0]],
        processorClockFrequency: [this.mobileFull?.processorClockFrequency != null ?
          this.mobileFull?.processorClockFrequency : null, [Validators.required, Validators.min]],
        coresNumber: [this.mobileFull?.coresNumber != null ? this.mobileFull?.coresNumber : null,
          [Validators.required, Validators.min]],
        technicalProcess: [this.mobileFull?.technicalProcess != null ? this.mobileFull?.technicalProcess : null,
          [Validators.required, Validators.min]]
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
      this.mobileFull.chipsetModel = this.controls.chipsetModel.value;
      this.mobileFull.processorClockFrequency = this.controls.processorClockFrequency.value;
      this.mobileFull.coresNumber = this.controls.coresNumber.value;
      this.mobileFull.technicalProcess = this.controls.technicalProcess.value;
    }
  }

}
