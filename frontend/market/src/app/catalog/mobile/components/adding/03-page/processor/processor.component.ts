import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  chipsetModels = mobileProperties.chipsetModels;


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        chipsetModel: [this.mobileDtoFull?.chipsetModel != null ? this.mobileDtoFull?.chipsetModel : this.chipsetModels[0]],
        processorClockFrequency: [this.mobileDtoFull?.processorClockFrequency != null ?
          this.mobileDtoFull?.processorClockFrequency : null, [Validators.required, Validators.min]],
        coresNumber: [this.mobileDtoFull?.coresNumber != null ? this.mobileDtoFull?.coresNumber : null,
          [Validators.required, Validators.min]],
        technicalProcess: [this.mobileDtoFull?.technicalProcess != null ? this.mobileDtoFull?.technicalProcess : null,
          [Validators.required, Validators.min]]
      });
  }

  onNext() {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.saveToMobileDtoFull();
    console.log(JSON.stringify(this.mobileDtoFull, null, 2));
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

  private saveToMobileDtoFull() {
    if (this.mobileDtoFull != null) {
      this.mobileDtoFull.chipsetModel = this.controls.chipsetModel.value;
      this.mobileDtoFull.processorClockFrequency = this.controls.processorClockFrequency.value;
      this.mobileDtoFull.coresNumber = this.controls.coresNumber.value;
      this.mobileDtoFull.technicalProcess = this.controls.technicalProcess.value;
    }
  }

}
