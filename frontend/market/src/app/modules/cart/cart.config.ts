import {InjectionToken} from '@angular/core';

export const MobileAPI = new InjectionToken<string>('MobileAPI', {
  providedIn: 'any',
  factory: () => 'http://localhost:8010'
});
