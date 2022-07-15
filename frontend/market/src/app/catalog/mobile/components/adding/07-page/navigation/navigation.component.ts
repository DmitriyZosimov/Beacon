import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

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
        gps: [this.mobileDtoFull?.gps ? this.mobileDtoFull?.gps : false],
        glonass: [this.mobileDtoFull?.glonass ? this.mobileDtoFull?.glonass : false],
        beidou: [this.mobileDtoFull?.beidou ? this.mobileDtoFull?.beidou : false]
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
      this.mobileDtoFull.gps = this.controls.gps.value;
      this.mobileDtoFull.glonass = this.controls.glonass.value;
      this.mobileDtoFull.beidou = this.controls.beidou.value;
    }
  }

}
