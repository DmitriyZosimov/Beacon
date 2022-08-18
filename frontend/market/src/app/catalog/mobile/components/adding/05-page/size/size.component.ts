import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-size',
  templateUrl: './size.component.html',
  styleUrls: ['./size.component.css']
})
export class SizeComponent implements OnInit {

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
        length: [this.mobileFull?.length != null ? this.mobileFull?.length : null,
          [Validators.required, Validators.min]],
        width: [this.mobileFull?.length != null ? this.mobileFull?.length : null,
          [Validators.required, Validators.min]],
        height: [this.mobileFull?.length != null ? this.mobileFull?.length : null,
          [Validators.required, Validators.min]],
        weight: [this.mobileFull?.length != null ? this.mobileFull?.length : null,
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
      this.mobileFull.length = this.controls.length.value;
      this.mobileFull.width = this.controls.width.value;
      this.mobileFull.height = this.controls.height.value;
      this.mobileFull.weight = this.controls.weight.value;
    }
  }
}
