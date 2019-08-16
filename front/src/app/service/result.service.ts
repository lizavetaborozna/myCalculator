import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  private resultsPath = 'http://localhost:8080/api/v1/results';
  private calculatorPath = 'http://localhost:8080/api/v1/calculator';
  private taxPath = 'http://localhost:8080/api/v1/tax';
  private filterPath = 'http://localhost:8080/api/v1/filter';
  private filterPath1 = 'http://localhost:8080/api/v1/filter1';
  private filterPath2 = 'http://localhost:8080/api/v1/filter2';

  constructor(private http: HttpClient) {
  }

  createResult(result: Object): Observable<Object> {
    return this.http.post(`${this.calculatorPath}`, result);
  }

  getResultsList(): Observable<any> {
    return this.http.get(`${this.resultsPath}`);
  }

  getCalculatedResult() {
    return this.http.get(`${this.taxPath}`, {headers: {'Content-Type': 'text'}});
  }

  getFilterResult(): Observable<any> {
    return this.http.get(`${this.filterPath}`);
  }

  getFilterResult1(): Observable<any> {
    return this.http.get(`${this.filterPath1}`);
  }

  getFilterResult2(): Observable<any> {
    return this.http.get(`${this.filterPath2}`);
  }
}
