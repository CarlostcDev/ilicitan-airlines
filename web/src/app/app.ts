import { Component, signal } from '@angular/core';
import {Header} from './shared/header/header';
import {Hero} from './features/hero/hero';

@Component({
  imports: [Header, Hero],
  selector: 'app-root',
  styleUrl: './app.scss',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');
}
