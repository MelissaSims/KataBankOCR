package com.bank.ocr;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Number n;
		String s;
		
		s = 
			" _ " +
			"| |" +
			"|_|";
		
		n = new Number(s);
		assertEquals("0",n.toString());
		assertEquals(0, Integer.parseInt(n.toString()));
		
		s = 
			"   " +
			"  |" +
			"  |";
		
		n = new Number(s);
		assertEquals("1",n.toString());
		assertEquals(1, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			" _|" +
			"|_ ";
		
		n = new Number(s);
		assertEquals("2",n.toString());
		assertEquals(2, Integer.parseInt(n.toString()));
				
		s =
			" _ " +
			" _|" +
			" _|";
		
		n = new Number(s);
		assertEquals("3",n.toString());
		assertEquals(3, Integer.parseInt(n.toString()));
		
		s =
			"   " +
			"|_|" +
			"  |";
		
		n = new Number(s);
		assertEquals("4",n.toString());
		assertEquals(4, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			"|_ " +
			" _|";
	
		n = new Number(s);
		assertEquals("5",n.toString());
		assertEquals(5, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			"|_ " +
			"|_|";
	
		n = new Number(s);
		assertEquals("6",n.toString());
		assertEquals(6, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			"  |" +
			"  |";
	
		n = new Number(s);
		assertEquals("7",n.toString());
		assertEquals(7, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			"|_|" +
			"|_|";
	
		n = new Number(s);
		assertEquals("8",n.toString());
		assertEquals(8, Integer.parseInt(n.toString()));
		
		s =
			" _ " +
			"|_|" +
			" _|";
	
		n = new Number(s);
		assertEquals("9",n.toString());
		assertEquals(9, Integer.parseInt(n.toString()));
		
		
		String a1, a2, a3;
		
		a1 =	"    _  _     _  _  _  _  _";
		a2 =	"  | _| _||_||_ |_   ||_||_|";
		a3 =	"  ||_  _|  | _||_|  ||_| _|";
		
		AccountNumber a = new AccountNumber(a1, a2, a3);
		assertEquals("123456789", a.getAccountNumber());
		
		s =
				"   " +
				"|_|" +
				"|_|";
		
		n = new Number(s);
		assertEquals("8", n.toString());
		
		s =
				" _ " +
				"|_ " +
				" _ ";
		
		n = new Number(s);
		assertEquals("5", n.toString());
		
		String b1, b2, b3;
		
			b1 =	"                           ";		
			b2 =	"  |  |  |  |  |  |  |  |  |";
			b3 =	"  |  |  |  |  |  |  |  |  |";
		
		AccountNumber b = new AccountNumber(b1, b2, b3);
		assertEquals("711111111", b.getAccountNumber());
		                           
		
		String c1, c2, c3;
		
			c1 =	" _  _  _  _  _  _  _  _  _ ";
			c2 =	"  |  |  |  |  |  |  |  |  |";
			c3 =	"  |  |  |  |  |  |  |  |  |";
		
		AccountNumber c = new AccountNumber(c1, c2, c3);
		assertEquals("777777177", c.getAccountNumber());
		
		String d1, d2, d3;
		
			d1 =	" _  _  _  _  _  _  _  _  _ ";
			d2 =	" _|| || || || || || || || |";
			d3 =	"|_ |_||_||_||_||_||_||_||_|";
				
		AccountNumber d = new AccountNumber(d1, d2, d3);
		assertEquals("200800000", d.getAccountNumber());
		
		String e1, e2, e3;
		
			e1 =	" _  _  _  _  _  _  _  _  _ ";
			e2 =	" _| _| _| _| _| _| _| _| _|";
			e3 =	" _| _| _| _| _| _| _| _| _|";
				                           
		AccountNumber e = new AccountNumber(e1, e2, e3);
		assertEquals("333393333", e.getAccountNumber());

		String f1, f2, f3;
		
			f1 =	" _  _  _  _  _  _  _  _  _ ";
			f2 =	"|_||_||_||_||_||_||_||_||_|";
			f3 =	"|_||_||_||_||_||_||_||_||_|";
				                           
		AccountNumber f = new AccountNumber(f1, f2, f3);
		assertEquals("888888888 AMB ['888886888', '888888880', '888888988']", f.getAccountNumber());
		
		String g1, g2, g3;
		
			g1 =	" _  _  _  _  _  _  _  _  _ ";
			g2 =	"|_ |_ |_ |_ |_ |_ |_ |_ |_ ";
			g3 =	" _| _| _| _| _| _| _| _| _|";
			
		AccountNumber g = new AccountNumber(g1, g2, g3);
		assertEquals("555555555 AMB ['555655555', '559555555']", g.getAccountNumber());
		
		String h1, h2, h3;
		
			h1 =	" _  _  _  _  _  _  _  _  _ ";
			h2 =	"|_ |_ |_ |_ |_ |_ |_ |_ |_ ";
			h3 =	"|_||_||_||_||_||_||_||_||_|";
		
		AccountNumber h = new AccountNumber(h1, h2, h3);
		assertEquals("666666666 AMB ['666566666', '686666666']", h.getAccountNumber());
				 
		String i1, i2, i3;
		
			i1 =	" _  _  _  _  _  _  _  _  _ ";
			i2 =	"|_||_||_||_||_||_||_||_||_|";
			i3 =	" _| _| _| _| _| _| _| _| _|";

		AccountNumber i = new AccountNumber(i1, i2, i3);
		assertEquals("999999999 AMB ['899999999', '993999999', '999959999']", i.getAccountNumber());
				 
		String j1, j2, j3;
		
			j1 =	"    _  _  _  _  _  _     _ ";
			j2 =	"|_||_|| || ||_   |  |  ||_ ";
			j3 =	"  | _||_||_||_|  |  |  | _|";

		AccountNumber j = new AccountNumber(j1, j2, j3);
		assertEquals("490067715 AMB ['490067115', '490067719', '490867715']", j.getAccountNumber());
				 
		String k1, k2, k3;
		
			k1 =	"    _  _     _  _  _  _  _ ";
		 	k2 =	" _| _| _||_||_ |_   ||_||_|";
			k3 =	"  ||_  _|  | _||_|  ||_| _|";

		AccountNumber k = new AccountNumber(k1, k2, k3);
		assertEquals("123456789", k.getAccountNumber());
		 
		String m1, m2, m3;
		
			m1 =	" _     _  _  _  _  _  _    ";
			m2 =	"| || || || || || || ||_   |";
			m3 =	"|_||_||_||_||_||_||_| _|  |";

		AccountNumber m = new AccountNumber(m1, m2, m3);
		assertEquals("000000051", m.getAccountNumber());
		 
		String p1, p2, p3;
		
			p1 =	"    _  _  _  _  _  _     _ ";
			p2 =	"|_||_|| ||_||_   |  |  | _ ";
			p3 =	"  | _||_||_||_|  |  |  | _|";

		AccountNumber p = new AccountNumber(p1, p2, p3);
		assertEquals("490867715", p.getAccountNumber());
	}
}
