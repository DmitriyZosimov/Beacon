import {InjectionToken} from '@angular/core';

export const SearchAPI = new InjectionToken<string>('SearchAPI', {
  providedIn: 'any',
  factory: () => 'http://localhost:8020'
});
