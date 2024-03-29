import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class JavaLocalTimeAdapter {

  private constructor() {}

  public adapt(localTime: string): Date {
    let values = localTime.split(':');
    let date = new Date();
    date.setHours(parseInt(values[0]), parseInt(values[1]), parseInt(values[2]));
    return date;
  }
}
