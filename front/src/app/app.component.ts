import {Component, OnInit} from '@angular/core';
import {ResultService} from "./service/result.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Калькулятор расчета';

  constructor(private resultService: ResultService,
              private router: Router) {
  }

  ngOnInit(): void {
  }
}


