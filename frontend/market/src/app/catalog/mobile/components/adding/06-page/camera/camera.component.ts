import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-camera',
  templateUrl: './camera.component.html',
  styleUrls: ['./camera.component.css']
})
export class CameraComponent implements OnInit {

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
        mainCamera: [this.mobileFull?.mainCamera ? this.mobileFull?.mainCamera : false],

        cameraResolution: [this.mobileFull?.cameraResolution != null ? this.mobileFull?.cameraResolution : null],

        mainCamerasNumber: [this.mobileFull?.mainCamerasNumber != null ? this.mobileFull?.mainCamerasNumber : null],

        builtInFlash: [this.mobileFull?.builtInFlash ? this.mobileFull?.builtInFlash : false],

        automaticFocus: [this.mobileFull?.automaticFocus ? this.mobileFull?.automaticFocus : false],

        opticalStabilization: [this.mobileFull?.opticalStabilization ?
          this.mobileFull?.opticalStabilization : false],

        mainCameraAperture: [this.mobileFull?.mainCameraAperture ? this.mobileFull?.mainCameraAperture : null],

        frontCamera: [this.mobileFull?.frontCamera ? this.mobileFull?.frontCamera : false],

        frontCameraResolution: [this.mobileFull?.frontCameraResolution != null ?
          this.mobileFull?.frontCameraResolution : null],

        frontCameraAperture: [this.mobileFull?.frontCameraAperture ? this.mobileFull?.frontCameraAperture : null],
      });
    this.enableMainCamerasProperties();
    this.enableFrontCamerasProperties();
    this.checkMainCamerasProperties();
    this.checkFrontCamerasProperties();
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
      this.mobileFull.cameraResolution = this.controls.cameraResolution.value;
      this.mobileFull.mainCamerasNumber = this.controls.mainCamerasNumber.value;
      this.mobileFull.builtInFlash = this.controls.builtInFlash.value;
      this.mobileFull.automaticFocus = this.controls.automaticFocus.value;
      this.mobileFull.opticalStabilization = this.controls.opticalStabilization.value;
      this.mobileFull.mainCamera = this.controls.mainCamera.value;
      this.mobileFull.mainCameraAperture = this.controls.mainCameraAperture.value;
      this.mobileFull.frontCamera = this.controls.frontCamera.value;
      this.mobileFull.frontCameraResolution = this.controls.frontCameraResolution.value;
      this.mobileFull.frontCameraAperture = this.controls.frontCameraAperture.value;
    }
  }

  private checkMainCamerasProperties() {
    this.form.get('mainCamera')?.valueChanges.subscribe(value => {
      if (value) {
        this.enableMainCamerasProperties();
      } else {
        this.disableMainCamerasProperties();
      }
      this.form.get('cameraResolution')?.updateValueAndValidity();
      this.form.get('mainCamerasNumber')?.updateValueAndValidity();
      this.form.get('mainCameraAperture')?.updateValueAndValidity();
    });
  }

  private enableMainCamerasProperties() {
    if (this.form.get('mainCamera')?.value) {
      this.form.get('cameraResolution')?.setValidators([Validators.required, Validators.min(0)]);
      this.form.get('mainCamerasNumber')?.setValidators([Validators.required, Validators.min(0)]);
      this.form.get('mainCameraAperture')?.setValidators([Validators.required, Validators.pattern('[0-9]{1}(\.){1}[0-9]{1,2}')]);
    }
  }

  private disableMainCamerasProperties() {
    if (!this.form.get('mainCamera')?.value) {
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
  }

  private checkFrontCamerasProperties() {
    this.form.get('frontCamera')?.valueChanges.subscribe(value => {
      if (value) {
        this.enableFrontCamerasProperties()
      } else {
        this.disableFrontCamerasProperties()
      }
      this.form.get('frontCameraResolution')?.updateValueAndValidity();
      this.form.get('frontCameraAperture')?.updateValueAndValidity();
    });
  }

  private enableFrontCamerasProperties() {
    if (this.form.get('frontCamera')?.value) {
      this.form.get('frontCameraResolution')?.setValidators([Validators.required, Validators.min(0)]);
      this.form.get('frontCameraAperture')?.setValidators([Validators.required, Validators.pattern('[0-9]{1}(\.){1}[0-9]{1,2}')]);
    }
  }

  private disableFrontCamerasProperties() {
    if (!this.form.get('frontCamera')?.value) {
      this.form.get('frontCameraResolution')?.clearValidators();
      this.form.get('frontCameraAperture')?.clearValidators();
      this.form.get('frontCameraResolution')?.setValue(null);
      this.form.get('frontCameraAperture')?.setValue(null);
    }
  }
}
