import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';

@Component({
  selector: 'app-am-perfil-componente',
  imports: [MatCardModule, MatChipsModule],
  templateUrl: './am-perfil-componente.html',
  styleUrl: './am-perfil-componente.scss',
})
export class AmPerfilComponente {
  estudiante = {
    nombre: 'Angello Martin Castillo Castillejo',
    carrera: 'Ingeniería de Sistemas de Información',
    ciclo: 'Por completar',
    skills: ['Angular', 'TypeScript', 'Spring Boot', 'Angular Material'],
    foto: 'foto-perfil.svg',
  };
}
