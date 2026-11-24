import {ChangeDetectionStrategy, Component} from '@angular/core';

@Component({
  imports: [],
  selector: 'app-hero',
  styleUrl: './hero.scss',
  templateUrl: './hero.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class Hero {

}
