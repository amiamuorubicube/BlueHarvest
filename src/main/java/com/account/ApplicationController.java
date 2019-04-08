package com.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.repository.AccountRepository;
import com.account.repository.ClientRepository;
import com.account.repository.TransactionRepository;
import com.account.services.AccountService;
import com.account.services.TransactionService;
import com.account.Entity.Account;
import com.account.Entity.Transaction;
import com.account.forms.AccountForm;

@Controller
public class ApplicationController {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	TransactionService TransactionService;
	
	@GetMapping("/")
    String index(Model model) {
		return "index";
    }
	
	@PostMapping("/create-account")
	@ResponseBody
    String createAccount(Model model, @ModelAttribute("AccountForm") final AccountForm form) {
		if(form.getClientId() != null && clientRepository.findById(form.getClientId()).isPresent() && form.getCredit() != null && form.getCredit().doubleValue() >= 0)
        {
        	Account account = new Account();
        	account.setClient(form.getClientId());
        	account.setCredit(form.getCredit());
        	Account saved = accountRepository.save(account);
        	if(form.getCredit().doubleValue() != 0)
        	{
        		Transaction transaction = new Transaction();
        		transaction.setAccount(saved.getId());
        		transaction.setAmount(form.getCredit());
        		transaction.setClient(form.getClientId());
        		transactionRepository.save(transaction);
        	}
        }
        else
        {
        	return "KO";
        }
        return "OK";
    }

	@GetMapping("/customer-info")
    String getcustomer(Model model, @ModelAttribute("AccountForm") final AccountForm form) {
	
		if(form.getClientId() != null && clientRepository.findById(form.getClientId()).isPresent())
        {
			List<Account> list= new ArrayList<Account>();
			list = accountService.findByClient(form.getClientId());
			model.addAttribute("client", clientRepository.findById(form.getClientId()).get());
			model.addAttribute("accounts", list);
			model.addAttribute("transactions", TransactionService.findByClient(form.getClientId()));
        }
		else
		{
			return "error";
		}
        return "customer-info";
    }
	
	@PostMapping("/make-transaction")
	@ResponseBody
    String makeTransaction(Model model, @ModelAttribute("AccountForm") final AccountForm form) {
		
		if(form.getClientId() != null && form.getId() != null && form.getCredit() != null && form.getCredit().doubleValue() >0 && clientRepository.findById(form.getClientId()).isPresent() 
				&& accountRepository.findById(form.getId()).isPresent())
        {
			Transaction transaction = new Transaction();
			transaction.setAccount(form.getId());
			transaction.setAmount(form.getCredit());
			transaction.setClient(form.getClientId());
        	transactionRepository.save(transaction);
        }
        else
        {
        	return "KO";
        }
        return "OK";
    }
}
