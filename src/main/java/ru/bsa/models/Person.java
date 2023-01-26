package ru.bsa.models;

import org.springframework.stereotype.Component;
import java.util.Objects;
@Component
public class Person {                                           // Пользователь (клиент)
        private long id;                                        // уникальный id
        private String name;                                    // имя
        private String email;                                   // email
        public Person(long id, String name, String email) {
                this.id = id;
                this.name = name;
                this.email = email;
        }
        public Person(String name, String email) {
                this.name = name;
                this.email = email;
        }
        public Person() {
        }
        public long getId() {
                return id;
        }
        public void setId(long id) {
                this.id = id;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return getId() == person.getId() && Objects.equals(getName(), person.getName()) && Objects.equals(getEmail(), person.getEmail());
        }
        @Override
        public int hashCode() {
                return Objects.hash(getId(), getName(), getEmail());
        }
        @Override
        public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}