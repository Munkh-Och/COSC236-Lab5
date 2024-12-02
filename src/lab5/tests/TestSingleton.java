package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import lab5.BorrowingService;

class TestSingleton {
		
	@Test void TestSingleton() {
		BorrowingService service1 = BorrowingService.getInstance();
		BorrowingService service2 = BorrowingService.getInstance();
		
		assertEquals(service1, service2, "Two Singleton instances detected");
	}
}
