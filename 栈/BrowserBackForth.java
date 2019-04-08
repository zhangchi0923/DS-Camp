package cn.sjtu.assignment01;
/**
 * 调用链式栈作为存放网址的栈
 * @author j
 *
 */
public class BrowserBackForth {
	public static void main(String[] args) {
		Browser b = new Browser();
		b.openNew("www.baidu.com");
		b.openNew("www.github.cn");
		b.openNew("www.jd.com");
		b.openNew("www.bilibili.com");
		
		b.getNow();
		b.back();
		b.back();
		b.forth();
	}
}
class Browser{
	LinkedStack<String> s1 = new LinkedStack<String>(20);//存储已经浏览过的地址
	LinkedStack<String> s2 = new LinkedStack<String>(20);//存储后退时出栈的地址
	
	//打开新网址
	public void openNew(String address) {
		s1.push(address);
	}
	//后退
	public void back() {
		s2.push(s1.pop().value);
		s1.peek();
	}
	//前进
	public void forth() {
		s2.peek();
		s1.push(s2.pop().value);
	}
	//获取当前页面
	public void getNow() {
		s1.peek();
	}
}