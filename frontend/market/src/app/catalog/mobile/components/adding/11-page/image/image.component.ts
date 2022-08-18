import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";

import {MobileFullModel, MobileMainImage, MobileNotMainImage} from "../../../../../../model/mobile";

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  images = new Array<string>();
  currentIndex = -1;
  changed = false;

  constructor(private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.displayImages();
  }

  displayImages() {
    if (this.mobileFull!.mainImage?.image != null) {
      this.images.push(this.encodeImage(this.mobileFull!.mainImage?.image));
      this.currentIndex = 0;
    }
    if (this.mobileFull!.notMainImages != null) {
      this.mobileFull!.notMainImages!.forEach(image => {
        if (image.image != null) {
          this.images.push(this.encodeImage(image.image));
        }
      })
    }
  }

  onBack() {
    this.onSave();
    this.page--;
    this.outputPage.emit(this.page);
  }

  onReview() {
    this.onSave();
    console.log("FINAL:\n" + JSON.stringify(this.mobileFull, null, 2));
    this.page++;
    this.outputPage.emit(this.page);
  }

  private onSave() {
    if (this.changed) {
      this.mobileFull!.mainImage = new MobileMainImage();
      this.mobileFull!.notMainImages = new Array<MobileNotMainImage>();
      this.images.forEach((image, index) => {
        if (this.currentIndex === index) {
          this.mobileFull!.mainImage!.image = this.decodeImage(image);
        } else {
          let notMainImage = new MobileNotMainImage();
          notMainImage.image = this.decodeImage(image);
          this.mobileFull!.notMainImages!.push(notMainImage)
        }
      });
    }
  }

  uploadImage(event: any) {
    const file: File = event.target.files[0];
    const reader = new FileReader();

    reader.readAsDataURL(file);

    reader.onload = (ev) => {
      let url = reader.result;
      if (typeof url === 'string') {
        this.images.push(url);
      }
    };
  }

  onDelete(index: number): void {
    this.images.splice(index, 1);
    if (this.currentIndex > index) {
      this.currentIndex--;
    } else if (this.currentIndex == index && this.images.length > 0) {
      this.currentIndex = 0;
    } else if (this.images.length == 0) {
      this.currentIndex = -1;
    }
  }

  private decodeImage(image: string): string {
    let index = image.indexOf('base64,');
    return image.substring(index + 7);
  }

  private encodeImage(image: string): string {
    return 'data:image/jpeg;base64,' + image;
  }
}
