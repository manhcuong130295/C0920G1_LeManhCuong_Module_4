package com.codegym.controller;

import com.codegym.entity.Bill;
import com.codegym.entity.Books;
import com.codegym.service.BillService;
import com.codegym.service.BookService;
import com.codegym.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CardService cardService;
    @Autowired
    private BillService billService;
    @GetMapping("create")
    public String createBook(Model model) {
        model.addAttribute("bookObj", new Books());
        return "add-book";
    }

    @GetMapping("/")
    public String listBook(Model model){
        model.addAttribute("listBook",this.bookService.findAll());
        return "index";
    }

    @PostMapping("create")
    public String saveBook(@ModelAttribute Books books) {
        bookService.save(books);
        return "redirect:/";
    }
    @GetMapping("rent")
    public String rent(Model model,@RequestParam int id){
        model.addAttribute("bookObj",bookService.findById(id));
        model.addAttribute("billObj",new Bill());
        model.addAttribute("list_card",cardService.findAll());
        return "rent-book";
    }
    @PostMapping("rent")
    public String rent(@ModelAttribute Bill bill,RedirectAttributes redirectAttributes) throws Exception {
        bill.setRentDate(billService.getToDay());
        Books books = bookService.findById(bill.getBooks().getIdBook());
      bookService.save(bookService.updateAmountBook("down",books));
      billService.saveBill(bill);
        redirectAttributes.addFlashAttribute("message","Success !");
        return "redirect:/";
    }
    @GetMapping("list-bill")
    public String returnBook(Model model,@PageableDefault(size = 5)Pageable pageable){
        model.addAttribute("billObj",new Bill());
        model.addAttribute("listBill",billService.findAll(pageable));
        return "list-bill";
    }
    @GetMapping("return")
    public String rent(@RequestParam int id, RedirectAttributes redirectAttributes) throws Exception {
        Books books = bookService.findById(billService.findById(id).getBooks().getIdBook());
        bookService.save(bookService.updateAmountBook("up",books));
        billService.remove(id);
        redirectAttributes.addFlashAttribute("message","Success !");
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String catchException() {
        return "redirect:rent/out-of-stock";
    }

    @GetMapping("rent/out-of-stock")
                public String errOutOfStock(){
        return "out-of-stock-err-page";
    }
}
