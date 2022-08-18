import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-common-properties',
  templateUrl: './common-properties.component.html',
  styleUrls: ['./common-properties.component.css']
})
export class CommonPropertiesComponent implements OnInit {
  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;
  currentYear = new Date().getFullYear();

  brands = mobileProperties.brands;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        brand: [this.mobileFull?.brand != null ? this.mobileFull?.brand : this.brands[0]],
        model: [this.mobileFull?.model != null ? this.mobileFull?.model : null, Validators.required],
        releaseYear: [this.mobileFull?.releaseYear != null ? this.mobileFull?.releaseYear : this.currentYear,
          [Validators.required, Validators.max, Validators.min]]
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
      this.mobileFull.brand = this.controls.brand.value;
      this.mobileFull.model = this.controls.model.value;
      this.mobileFull.releaseYear = this.controls.releaseYear.value;
    }
  }

}
