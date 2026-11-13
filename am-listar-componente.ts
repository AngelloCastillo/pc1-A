import { Component, inject, OnInit, signal } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CarbonFootprint } from '../../services/carbon-footprint';
import { CarbonFootprintAI } from '../../models/carbon-footprint-ai';

@Component({
  selector: 'app-am-listar-componente',
  imports: [MatTableModule, MatButtonModule, MatIconModule, DecimalPipe],
  templateUrl: './am-listar-componente.html',
  styleUrl: './am-listar-componente.scss',
})
export class AmListarComponente implements OnInit {
  private readonly carbonFootprint = inject(CarbonFootprint);
  private readonly snackBar = inject(MatSnackBar);

  columnas: string[] = [
    'idCarbonFootprint',
    'aiModelName',
    'energyConsumption',
    'numberOfRequests',
    'measurementDate',
    'measurementTime',
    'acciones',
  ];
  huellas = signal<CarbonFootprintAI[]>([]);

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.carbonFootprint.listar().subscribe({
      next: (datos) => this.huellas.set(datos),
      error: () =>
        this.snackBar.open('No se pudo conectar con el servidor', 'Cerrar', { duration: 4000 }),
    });
  }

  eliminar(id: number): void {
    this.carbonFootprint.eliminar(id).subscribe({
      next: () => {
        this.cargar();
        this.snackBar.open('Huella de carbono eliminada correctamente', 'Cerrar', {
          duration: 3000,
        });
      },
      error: () =>
        this.snackBar.open('No se pudo eliminar la huella de carbono', 'Cerrar', {
          duration: 4000,
        }),
    });
  }
}
