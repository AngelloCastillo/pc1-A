import { Routes } from '@angular/router';
import { AmListarComponente } from './pages/am-listar-componente/am-listar-componente';
import { AmPerfilComponente } from './pages/am-perfil-componente/am-perfil-componente';

export const routes: Routes = [
  { path: '', redirectTo: 'angello/listar', pathMatch: 'full' },
  { path: 'angello/listar', component: AmListarComponente },
  { path: 'angello/certificado', component: AmPerfilComponente },
  { path: '**', redirectTo: 'angello/listar' },
];
