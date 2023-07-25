package com.final_project.stock.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.final_project.stock.dao.AccountInfoDao;
import com.final_project.stock.dao.StockPriceDao;
import com.final_project.stock.dao.TradeHistoryDao;
import com.final_project.stock.dao.UserTableDao;
import com.final_project.stock.dto.AccountInfoDto;
import com.final_project.stock.dto.StockPriceEmartDto;
import com.final_project.stock.dto.StockPriceShinDto;
import com.final_project.stock.dto.StockPriceShinFood;
import com.final_project.stock.dto.TradingHistoryDto;
import com.final_project.stock.dto.UserTableDto;
import com.final_project.stock.service.UserTableService;


@Controller
@RequestMapping("/stock")
public class FinalStockController {
	
	UserTableDao usertableDao;
	@Autowired
	public FinalStockController(UserTableDao usertableDao) {
		this.usertableDao = usertableDao;
	}

	
	@Value("${stock.imgdir}")
	String fdir;

	
	@GetMapping("/main")
	public String loginbeforemainpage() {
		return "loginbefore";
	}
	@GetMapping("/login/kospi&exchange")
	public String main_kospi_exchange(Model model, HttpServletRequest request,
			@RequestParam(defaultValue = "/") String redirectURL) {
		UserTableDto userdto;
		try {
			HttpSession session = request.getSession();
			String insertsession = (String) session.getAttribute("userid");
			userdto = usertableDao.searchAll(insertsession);
			session.setAttribute("image", userdto);
			session.setAttribute("username", userdto.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main_kospi_exchange";
	}

	
	@GetMapping("/login/stockchart")
	public String main_stock_chart(Model model) {
		StockPriceDao stockPriceDao = new StockPriceDao();
		StockPriceShinDto shinPrice = null;
		StockPriceShinFood shinFoodPrice = null;
		StockPriceEmartDto EmartPrice = null;
		try {
			shinPrice = stockPriceDao.searchShinRecent();
			shinFoodPrice = stockPriceDao.searchShinFoodRecent();
			EmartPrice = stockPriceDao.searchEmartRecent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("shinPrice", shinPrice);
		model.addAttribute("shinFoodPrice", shinFoodPrice);
		model.addAttribute("EmartPrice", EmartPrice);
		return "main_stock_chart";
	}
	
	@GetMapping("/login/accountinfo")
	public String main_account_info(Model model) {
		TradeHistoryDao tradingHistroyDao = new TradeHistoryDao();
		AccountInfoDao accountInfo = new AccountInfoDao();
		try {
			ArrayList<TradingHistoryDto> AllHistoryList = tradingHistroyDao.tradingAllHistory();
			model.addAttribute("AllTradingHistory", AllHistoryList);
			AccountInfoDto AccountInfo = accountInfo.getAccountInfo();
			String odrbqty = AccountInfo.getOdrbqty();
			String trbqty = AccountInfo.getTrbqty();
			String avalpri = AccountInfo.getAvalpri();
			String valgalo = AccountInfo.getValgalo();
			String garate = AccountInfo.getGarate();
			String garate1 = garate.substring(0,7);
			model.addAttribute("Odrbqty", odrbqty);
			model.addAttribute("Trbqty", trbqty);
			model.addAttribute("Avalpri", avalpri);
			model.addAttribute("Valgalo", valgalo);
			model.addAttribute("Garate", garate1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main_account_info";
	}
		
	@GetMapping("/login/profit&losschart")
	public String main_profit_loss_chart() {
		return "main_profit_loss_chart";
	}
	
	@GetMapping("/login/news")
	public String main_news_info() {
		return "main_news_info";
	}
	
	@GetMapping("/login/siteintroduce")
	public String main_site_introduce() {
		return "main_site_introduce";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	
	@PostMapping("/up")
	public String signup(@ModelAttribute UserTableDto usertableDto, Model model,
			@RequestParam("file") MultipartFile file, RedirectAttributes red) {
		// 2.0 파일 처리 => 파일 객체 생성, 저장
		File dest = new File(fdir + "/" + file.getOriginalFilename()); // 파일 생성x(경로+파일명)

		try {
			// 2.1 정상처리
			file.transferTo(dest);// 파일 저장
			usertableDto.setImgnm("/images/" + dest.getName());// 중복이미지일시 변경된이름으로get
			usertableDao.insert(usertableDto);
			red.addFlashAttribute("msg", "<script>alert('회원가입을 축하합니다.');</script>");
		} catch (Exception e) {
			// 2.2 비정상처리 => 화면에 비정상처리 경고메세지보내야함
			e.printStackTrace();
			model.addAttribute("error", "회원가입이 정상적으로되지 않았습니다.");
			red.addFlashAttribute("msg", "<script>alert('회원가입에 실패하셨습니다. 다시 회원가입해주세요');</script>");
		}

		return "redirect:/stock/signin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public int idCheck(@RequestParam("userid") String userid) {
		// select * from member where userid = #{};
		// 이 member 객체에는 id만 값이 들어있고, 다른 것은 다 null 값이다.
		int check = 0;
		try {
			ArrayList<UserTableDto> list = usertableDao.signupidcheck(userid);
			if (list.size() > 0) {
				check = 1;
			} else {
				check = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	@PostMapping("/in")
	public String signin(@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "userpassword", required = false) String userpassword, Model model,
			HttpServletRequest request, RedirectAttributes red) {
		UserTableService usertableservice = new UserTableService();
		int check;
		try {
			usertableservice.equalcheck(userid, userpassword);
			check = usertableservice.equalcheck(userid, userpassword);

			if (check == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("userpassword", userpassword);
				red.addFlashAttribute("msg", "<script>alert('로그인에 성공하셨습니다.');</script>");
			} else {
				red.addFlashAttribute("msg", "<script>alert('로그인에 실패하셨습니다. 다시 로그인해주세요');</script>");
				return "redirect:/stock/signin";
			}
		} catch (Exception e) {
			// 2.2 비정상처리 => 화면에 비정상처리 경고메세지보내야함
			e.printStackTrace();
			model.addAttribute("error", "로그인이 정상적으로되지 않았습니다.");
		}
		return "redirect:/stock/login/kospi&exchange";

	}
	
	@GetMapping("/removesession")
	public String removesession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		return "redirect:/stock/main";
	}
	

	
}