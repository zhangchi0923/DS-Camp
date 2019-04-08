package cn.sjtu.assignment01;
/**
 * ������ʽջ��Ϊ�����ַ��ջ
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
	LinkedStack<String> s1 = new LinkedStack<String>(20);//�洢�Ѿ�������ĵ�ַ
	LinkedStack<String> s2 = new LinkedStack<String>(20);//�洢����ʱ��ջ�ĵ�ַ
	
	//������ַ
	public void openNew(String address) {
		s1.push(address);
	}
	//����
	public void back() {
		s2.push(s1.pop().value);
		s1.peek();
	}
	//ǰ��
	public void forth() {
		s2.peek();
		s1.push(s2.pop().value);
	}
	//��ȡ��ǰҳ��
	public void getNow() {
		s1.peek();
	}
}