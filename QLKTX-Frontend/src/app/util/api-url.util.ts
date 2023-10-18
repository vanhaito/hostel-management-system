import {environment} from '../../environments/environment';
import { RequestParam } from '../data/request-param';
// import {RequestParam} from '../_model/common/request-param';

export class ApiUrlUtil {

  public static buildQueryString(path: string, params?: RequestParam[]): string {
    let url = '';
    url += path;

    if (params && params.length > 0) {
      for (let i = 0; i < params.length; i++) {
        if (i === 0) {
          url += '?';
        } else {
          url += '&';
        }
        url += params[i].name;
        url += '=';
        url += params[i].value;
      }
    }
    return url;
  }

}
