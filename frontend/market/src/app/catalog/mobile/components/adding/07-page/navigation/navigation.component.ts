import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

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
        gps: [this.mobileFull?.gps ? this.mobileFull?.gps : false],
        glonass: [this.mobileFull?.glonass ? this.mobileFull?.glonass : false],
        beidou: [this.mobileFull?.beidou ? this.mobileFull?.beidou : false]
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
      this.mobileFull.gps = this.controls.gps.value;
      this.mobileFull.glonass = this.controls.glonass.value;
      this.mobileFull.beidou = this.controls.beidou.value;
    }
  }

}
