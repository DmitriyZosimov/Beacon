// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  catalogServer: 'http://localhost:8010',
  searchServer: 'http://localhost:8020',
  shopServer: 'http://localhost:8030',

  //Authentication
  clientId: 'beacon-market',
  redirectUri:"http://localhost:4200/mobile",
  tokenUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/token',
  authUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/auth',
  logoutUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/logout'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
