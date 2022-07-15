import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";

@Component({
  selector: 'app-common-properties',
  templateUrl: './common-properties.component.html',
  styleUrls: ['./common-properties.component.css']
})
export class CommonPropertiesComponent implements OnInit {
  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
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
        brand: [this.mobileDtoFull?.brand != null ? this.mobileDtoFull?.brand : this.brands[0]],
        model: [this.mobileDtoFull?.model != null ? this.mobileDtoFull?.model : null, Validators.required],
        releaseYear: [this.mobileDtoFull?.releaseYear != null ? this.mobileDtoFull?.releaseYear : this.currentYear,
          [Validators.required, Validators.max, Validators.min]]
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
      this.mobileDtoFull.brand = this.controls.brand.value;
      this.mobileDtoFull.model = this.controls.model.value;
      this.mobileDtoFull.releaseYear = this.controls.releaseYear.value;
    }
  }

}
