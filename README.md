# Welcome to My Automated Test Repo!
There are two practices to coding and running automated tests. 

## Getting Started
I have used a couple of frameworks in this practice. You can see all the dependencies on pom.xml.

### Selenium WebDriver
- Bu test otomasyon sürecinde Java diliyle beraber Selenium WebDriver aracını tercih ettim.
- Bu testte Selenium WebDriver'ın 4.25.0 versiyonunu kullandım.
- Selenium WebDriver için bize lazım olan iki şey var: Bir tarayıcı ve tarayıcının webdriver'ı.
- Ben burada tercihimi Mozilla Firefox'tan yana yaptım.

### BDD
- BDD, yazılımın iş gereksinimlerini anlamaya ve bu gereksinimlere dayalı olarak geliştirmeye yardımcı olur.
- BDD, teknik ve teknik olmayan ekip üyeleri arasında iletişimi kolaylaştırır ve tüm paydaşların anlaması için senaryolar oluşturur.
- Geliştirme sürecinin başında test senaryolarının yazılmasına olanak tanır bu da gereksinim analizini kolaylaştırıyor.
- BDD senaryoları, otomatik testler olarak uygulanabilir, bu da yazılımın belirli işlevlerini sürekli olarak test etme imkanı sunar.

### TestNG
- TestNG, testlerimizi yazdığımız kaynak kodunun hem daha temiz görünmesini sağlar.
- _@BeforeMethod_, _@Test_, _@AfterMethod_ gibi anotasyonlarla testlerimizin statuslarını gösterir.
- Ayrıca testlerimizi eşzamanlı çalıştırarak test sürelerini kısaltır.
- Testleri gruplayarak farklı test senaryolarını farklı koşullara göre çalıştırmayı sağlar.

### RestAssured
- RESTful API'lerle etkileşim kurmayı basit hale getirir. HTTP isteklerini kolayca oluşturmanıza olanak tanır.
- Test senaryolarını yazarken Java'da kullanılan anotasyonları (mesela, JUnit veya TestNG) destekler.
- API yanıtlarını daha anlamlı hale getirmek için Java sınıflarıyla veri eşleme (mapping) imkanı sunar.
- Otomatik test senaryoları yazmak için uygun bir yapı sağlar, bu da CI/CD süreçlerinde kullanımını kolaylaştırır.
- Hata ayıklama ve test sonuçlarını görüntüleme için ayrıntılı hata mesajları sunar.

<hr>

## Test Automation - I (UI)

### BDD Structure
Firstly we should write our scenarios in BDD structure.
```cucumber
Feature: Like the first comment on Amazon product

  Scenario: Liking the first comment of a product
    Given I open https://www.amazon.com.tr
    When I user search for "iphone" in the search bar
    Then I user retrieve the list of products
    And I user click on the first product
    And I user navigate to the comments section
    Then I user click the like button on the first comment
```

## Test Automation - II (API)
