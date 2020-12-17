package carmelo.web;

import carmelo.data.model.Person;
import com.vaadin.data.Binder;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;

public class PersonForm extends FormLayout {

    Binder<Person> binder = new Binder<>(Person.class);
    
    TextField name = new TextField("Nombre");
    TextField email = new TextField("Correo");
    Slider edad = new Slider("Edad");
    
    Person person;
     
    public PersonForm() {
        
        person = new Person();
        person.setName("Juan Pablo");
        person.setEmail("juan@mail.es");
        person.setAge(35);
        
        name.setPlaceholder("Escribe tu nombre");
        email.setPlaceholder("Escribe tu correo");
        
        addComponents(name, email, edad);
        
        binder.forField(edad)           
                .withConverter(Double::intValue, Integer::doubleValue)
                .bind(Person::getAge, Person::setAge);
        
        binder.bindInstanceFields(this);
        binder.readBean(person);   
       
    }
      
}
