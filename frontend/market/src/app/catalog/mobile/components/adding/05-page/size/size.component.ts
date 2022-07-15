import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";

@Component({
  selector: 'app-size',
  templateUrl: './size.component.html',
  styleUrls: ['./size.component.css']
})
export class SizeComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        length: [this.mobileDtoFull?.length != null ? this.mobileDtoFull?.length : null,
          [Validators.required, Validators.min]],
        width: [this.mobileDtoFull?.length != null ? this.mobileDtoFull?.length : null,
          [Validators.required, Validators.min]],
        height: [this.mobileDtoFull?.length != null ? this.mobileDtoFull?.length : null,
          [Validators.required, Validators.min]],
        weight: [this.mobileDtoFull?.length != null ? this.mobileDtoFull?.length : null,
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
      this.mobileDtoFull.length = this.controls.length.value;
      this.mobileDtoFull.width = this.controls.width.value;
      this.mobileDtoFull.height = this.controls.height.value;
      this.mobileDtoFull.weight = this.controls.weight.value;
    }
  }
}
