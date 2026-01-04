import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-account-create',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './account-create.html'
})
export class AccountCreateComponent {
  account = { name: '', balance: 0 };

  constructor(private service: AccountService) {}

  create() {
    this.service.createAccount(this.account).subscribe(res => {
      alert('Account Created with ID: ' + res.id);
    });
  }
}
