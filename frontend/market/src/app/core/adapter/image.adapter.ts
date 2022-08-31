import {Injectable} from "@angular/core";
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Injectable({
  providedIn: 'root'
})
export class ImageAdapter {

  constructor(
    private sanitizer: DomSanitizer
  ){}

  adapt(image: string): SafeUrl {
    let objectUrl = 'data:image/jpeg;base64,' + image;
    return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
  }
}
