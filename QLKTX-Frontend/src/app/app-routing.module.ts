import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NguoiComponent } from './module/nguoi/nguoi.component';

const routes: Routes = [
  {path: '',component: AppComponent},
  {path: 'home',component: AppComponent},
  {path: 'nguoi',component: NguoiComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
