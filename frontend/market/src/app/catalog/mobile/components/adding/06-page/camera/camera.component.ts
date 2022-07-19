import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";

@Component({
  selector: 'app-camera',
  templateUrl: './camera.component.html',
  styleUrls: ['./camera.component.css']
})
export class CameraComponent implements OnInit {

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
        mainCamera: [this.mobileDtoFull?.mainCamera ? this.mobileDtoFull?.mainCamera : false],

        cameraResolution: [this.mobileDtoFull?.cameraResolution != null ? this.mobileDtoFull?.cameraResolution : null],

        mainCamerasNumber: [this.mobileDtoFull?.mainCamerasNumber != null ? this.mobileDtoFull?.mainCamerasNumber : null],

        builtInFlash: [this.mobileDtoFull?.builtInFlash ? this.mobileDtoFull?.builtInFlash : false],

        automaticFocus: [this.mobileDtoFull?.automaticFocus ? this.mobileDtoFull?.automaticFocus : false],

        opticalStabilization: [this.mobileDtoFull?.opticalStabilization ?
          this.mobileDtoFull?.opticalStabilization : false],

        mainCameraAperture: [this.mobileDtoFull?.mainCameraAperture ? this.mobileDtoFull?.mainCameraAperture : null],

        frontCamera: [this.mobileDtoFull?.frontCamera ? this.mobileDtoFull?.frontCamera : false],

        frontCameraResolution: [this.mobileDtoFull?.frontCameraResolution != null ?
          this.mobileDtoFull?.frontCameraResolution : null],

        frontCameraAperture: [this.mobileDtoFull?.frontCameraAperture ? this.mobileDtoFull?.frontCameraAperture : null],
      });
    this.checkMainCamerasProperties();
    this.checkFrontCamerasProperties();
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
      this.mobileDtoFull.cameraResolution = this.controls.cameraResolution.value;
      this.mobileDtoFull.mainCamerasNumber = this.controls.mainCamerasNumber.value;
      this.mobileDtoFull.builtInFlash = this.controls.builtInFlash.value;
      this.mobileDtoFull.automaticFocus = this.controls.automaticFocus.value;
      this.mobileDtoFull.opticalStabilization = this.controls.opticalStabilization.value;
      this.mobileDtoFull.mainCamera = this.controls.mainCamera.value;
      this.mobileDtoFull.mainCameraAperture = 'f/' + this.controls.mainCameraAperture.value;
      this.mobileDtoFull.frontCamera = this.controls.frontCamera.value;
      this.mobileDtoFull.frontCameraResolution = this.controls.frontCameraResolution.value;
      this.mobileDtoFull.frontCameraAperture = 'f/' + this.controls.frontCameraAperture.value;
    }
  }

  private checkMainCamerasProperties() {
    this.form.get('mainCamera')?.valueChanges.subscribe(value => {
      if (value) {
        this.form.get('cameraResolution')?.setValidators([Validators.required, Validators.min(0)]);
        this.form.get('mainCamerasNumber')?.setValidators([Validators.required, Validators.min(0)]);
        this.form.get('mainCameraAperture')?.setValidators([Validators.required, Validators.min(0)]);
      } else {
        this.form.get('cameraResolution')?.clearValidators();
        this.form.get('mainCamerasNumber')?.clearValidators();
        this.form.get('mainCameraAperture')?.clearValidators();
        this.form.get('cameraResolution')?.setValue(null);
        this.form.get('mainCamerasNumber')?.setValue(null);
        this.form.get('mainCameraAperture')?.setValue(null);
        this.form.get('builtInFlash')?.setValue(false);
        this.form.get('automaticFocus')?.setValue(false);
        this.form.get('opticalStabilization')?.setValue(false);
      }
      this.form.get('cameraResolution')?.updateValueAndValidity();
      this.form.get('mainCamerasNumber')?.updateValueAndValidity();
      this.form.get('mainCameraAperture')?.updateValueAndValidity();
    });
  }

  private checkFrontCamerasProperties() {
    this.form.get('frontCamera')?.valueChanges.subscribe(value => {
      if (value) {
        this.form.get('frontCameraResolution')?.setValidators([Validators.required, Validators.min(0)]);
        this.form.get('frontCameraAperture')?.setValidators([Validators.required, Validators.min(0)]);
      } else {
        this.form.get('frontCameraResolution')?.clearValidators();
        this.form.get('frontCameraAperture')?.clearValidators();
        this.form.get('frontCameraResolution')?.setValue(null);
        this.form.get('frontCameraAperture')?.setValue(null);
      }
      this.form.get('frontCameraResolution')?.updateValueAndValidity();
      this.form.get('frontCameraAperture')?.updateValueAndValidity();
    });
  }

}
