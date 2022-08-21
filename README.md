<h1 align="center"> Beyzanur Özer - Enuygun PetStoreAPI Projesi </h1>

> >##  ``` https://petstore.swagger.io/ servisi kullanılarak testler yazıldı.  ```

## PetsStoreTest
Bu sınıf içerisinde Rest Assured kullanılarak <br>https://petstore.swagger.io/<br> sitesinde bulunna farklı sınıflar için testler yazıldı.

## Ek bilgiler

> #Not1:
Raporlama için allure report kullanılmıştır. Test çalıştıktan sonra otomatik olarak "Seleniumproject" altında <b>Allure-results</b> dosyası oluşacaktır. Terminalden projesenin bulunduğu dizinde <b>Allure serve allure-results</b> yazarak test raporlarına ulaşılabilir.

> #Not2:
<br>https://petstore.swagger.io/v2/pet/findByStatus?status=available<br> isteğinden dönen değer farklı zamanlarda deneğimde yapısal olarak değişiklik gösterebiliyor.
Bu istekten dönen verinin üçüncü "id" bilgisini farklı bir istekte kullanırken yapılan parse işlemini uyguladığım <br>https://petstore.swagger.io/v2/pet/findByStatus?status=available<br> isteğinden dönen yapı aşağıdadır.

<img src="https://github.com/nurbeyza/EnUygunBitirmePetStoreAPI/blob/main/100%C4%B1.JPG" width="auto">

