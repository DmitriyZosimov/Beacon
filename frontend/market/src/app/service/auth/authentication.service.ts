import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Cookie} from "ng2-cookies";
import {Observable} from "rxjs";

@Injectable()
export class AuthenticationService {

  private clientId = environment.clientId;
  private redirectUri = environment.redirectUri;
  private tokenUrl = environment.tokenUrl;
  private authUrl = environment.authUrl;
  private logoutUrl = environment.logoutUrl;

  constructor(protected httpClient: HttpClient) {
  }

  retrieveToken(code: any) {
    const params = new URLSearchParams();
    params.append('grant_type', 'authorization_code');
    params.append('client_id', this.clientId);
    params.append('redirect_uri', this.redirectUri);
    params.append('code', code);

    console.log(this.redirectUri);
    const headers = new HttpHeaders(
      {'Content-type': 'application/x-www-form-urlencoded; charset=utf-8'}
    );

    this.httpClient.post(this.tokenUrl,
      params.toString(), {headers: headers})
      .subscribe(data => {
          this.saveToken(data);
          window.location.href = this.redirectUri;
        },
        err => alert('Invalid Credentials'));
  }

  saveToken(token: any) {
    let expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate, '/');
    Cookie.set("id_token", token.id_token, expireDate, '/');
    Cookie.set("refresh_token", token.refresh_token, expireDate, '/');
  }

  refreshToken(): Observable<Object> {
    const params = new URLSearchParams();
    params.append('grant_type', 'refresh_token');
    params.append('client_id', this.clientId);
    params.append('refresh_token', Cookie.get('refresh_token'));

    const headers = new HttpHeaders(
      {'Content-type': 'application/x-www-form-urlencoded; charset=utf-8'}
    );

    return this.httpClient.post(this.tokenUrl,
      params.toString(), {headers: headers})
  }

  checkCredentials(): boolean {
    return Cookie.check('access_token') && Cookie.check('id_token')
  }

  login() {
    let params = new HttpParams()
      .append('response_type', 'code')
      .append('scope', 'openid')
      .append('client_id', this.clientId)
      .append('redirect_uri', this.redirectUri);
    window.location.href = this.authUrl + '?' + params.toString();
  }

  logout() {
    let params = new HttpParams()
      .append('client_id', this.clientId)
      .append('id_token_hint', Cookie.get('id_token'))
      .append('post_logout_redirect_uri', this.redirectUri);
    Cookie.delete('access_token', '/');
    Cookie.delete('id_token', '/');
    Cookie.delete('refresh_token', '/');
    window.location.href = this.logoutUrl + '?' + params.toString();
  }
}
