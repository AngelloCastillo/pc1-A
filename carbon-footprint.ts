import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CarbonFootprintAI } from '../models/carbon-footprint-ai';

@Injectable({
  providedIn: 'root',
})
export class CarbonFootprint {
  private readonly http = inject(HttpClient);
  private readonly url = 'http://localhost:8085/api/carbonfoots';

  listar(): Observable<CarbonFootprintAI[]> {
    return this.http.get<CarbonFootprintAI[]>(this.url);
  }

  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
