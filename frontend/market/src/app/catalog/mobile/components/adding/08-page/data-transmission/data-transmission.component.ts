import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-data-transmission',
  templateUrl: './data-transmission.component.html',
  styleUrls: ['./data-transmission.component.css']
})
export class DataTransmissionComponent implements OnInit {

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
        edge: [this.mobileDtoFull?.edge ? this.mobileDtoFull?.edge : false],
        hspa: [this.mobileDtoFull?.hspa ? this.mobileDtoFull?.hspa : false],
        hspaPlus: [this.mobileDtoFull?.hspaPlus ? this.mobileDtoFull?.hspaPlus : false],
        lte: [this.mobileDtoFull?.lte ? this.mobileDtoFull?.lte : false],
        fiveG: [this.mobileDtoFull?.fiveG ? this.mobileDtoFull?.fiveG : false]
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
      this.mobileDtoFull.edge = this.controls.edge.value;
      this.mobileDtoFull.hspa = this.controls.hspa.value;
      this.mobileDtoFull.hspaPlus = this.controls.hspaPlus.value;
      this.mobileDtoFull.lte = this.controls.lte.value;
      this.mobileDtoFull.fiveG = this.controls.fiveG.value;
    }
  }

}
