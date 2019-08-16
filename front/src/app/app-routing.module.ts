import  { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResultListComponent } from './result-list/result-list.component';
import {CalculatorComponent} from "./calculator/calculator.component";


const routes: Routes = [
  { path: '', redirectTo: '/calculator', pathMatch: 'full' },
  { path: 'results', component: ResultListComponent },
  { path: 'calculator', component: CalculatorComponent },
  { path: 'tax', component: CalculatorComponent },
  { path: 'filter', component: ResultListComponent },
  { path: 'filter1', component: ResultListComponent },
  { path: 'filter2', component: ResultListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
