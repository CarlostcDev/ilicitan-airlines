import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive} from '@angular/router';
import {NgOptimizedImage} from '@angular/common';

@Component({
  imports: [
    RouterLink,
    NgOptimizedImage,
    RouterLinkActive
  ],
  selector: 'app-header',
  styleUrl: './header.scss',
  templateUrl: './header.html',
})
export class Header {}
