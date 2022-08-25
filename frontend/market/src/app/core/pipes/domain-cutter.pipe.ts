import { Pipe, PipeTransform } from '@angular/core';
import {environment} from "../../../environments/environment";

@Pipe({
  name: 'domainCutter'
})
export class DomainCutterPipe implements PipeTransform {

  private domainUrl = environment.domainUrl;

  transform(value: any, ...args: any[]): string {
    if (value) {
      return value.substring(this.domainUrl.length);
    }
    return '';
  }

}
