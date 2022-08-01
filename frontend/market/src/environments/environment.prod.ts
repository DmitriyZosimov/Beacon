export const environment = {
  production: true,
  catalogServer: 'http://localhost:8010',
  searchServer: 'http://localhost:8020',

  //Authentication
  clientId: 'beacon-market',
  redirectUri:"http://localhost:4200/mobile",
  tokenUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/token',
  authUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/auth',
  logoutUrl: 'http://localhost:8180/realms/catalog/protocol/openid-connect/logout'
};
