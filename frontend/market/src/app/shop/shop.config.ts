import {InjectionToken} from '@angular/core';

export const ShopAPI = new InjectionToken<string>('ShopAPI', {
  providedIn: 'any',
  factory: () => 'http://localhost:8030'
});
