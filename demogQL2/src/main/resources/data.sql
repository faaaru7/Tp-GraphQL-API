-- Insertion des Authors (70 auteurs)
-- Utiliser les noms de colonnes en snake_case générés par JPA
INSERT INTO author (name, age, nationality) VALUES ('Victor Hugo', 83, 'French');
INSERT INTO author (name, age, nationality) VALUES ('William Shakespeare', 52, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Jane Austen', 41, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Charles Dickens', 58, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Mark Twain', 74, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Ernest Hemingway', 61, 'American');
INSERT INTO author (name, age, nationality) VALUES ('F. Scott Fitzgerald', 44, 'American');
INSERT INTO author (name, age, nationality) VALUES ('George Orwell', 46, 'English');
INSERT INTO author (name, age, nationality) VALUES ('J.K. Rowling', 59, 'British');
INSERT INTO author (name, age, nationality) VALUES ('Stephen King', 77, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Agatha Christie', 85, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Leo Tolstoy', 82, 'Russian');
INSERT INTO author (name, age, nationality) VALUES ('Fyodor Dostoevsky', 59, 'Russian');
INSERT INTO author (name, age, nationality) VALUES ('Gabriel García Márquez', 87, 'Colombian');
INSERT INTO author (name, age, nationality) VALUES ('Pablo Neruda', 69, 'Chilean');
INSERT INTO author (name, age, nationality) VALUES ('Jorge Luis Borges', 86, 'Argentine');
INSERT INTO author (name, age, nationality) VALUES ('Albert Camus', 46, 'French');
INSERT INTO author (name, age, nationality) VALUES ('Jean-Paul Sartre', 74, 'French');
INSERT INTO author (name, age, nationality) VALUES ('Simone de Beauvoir', 78, 'French');
INSERT INTO author (name, age, nationality) VALUES ('Marcel Proust', 51, 'French');
INSERT INTO author (name, age, nationality) VALUES ('Franz Kafka', 40, 'Czech');
INSERT INTO author (name, age, nationality) VALUES ('James Joyce', 58, 'Irish');
INSERT INTO author (name, age, nationality) VALUES ('Virginia Woolf', 59, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Oscar Wilde', 46, 'Irish');
INSERT INTO author (name, age, nationality) VALUES ('Emily Brontë', 30, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Charlotte Brontë', 38, 'English');
INSERT INTO author (name, age, nationality) VALUES ('Herman Melville', 72, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Edgar Allan Poe', 40, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Nathaniel Hawthorne', 64, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Ralph Waldo Emerson', 78, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Henry David Thoreau', 44, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Walt Whitman', 72, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Emily Dickinson', 55, 'American');
INSERT INTO author (name, age, nationality) VALUES ('T.S. Eliot', 76, 'British-American');
INSERT INTO author (name, age, nationality) VALUES ('Ezra Pound', 87, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Sylvia Plath', 30, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Maya Angelou', 86, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Toni Morrison', 88, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Alice Walker', 80, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Margaret Atwood', 85, 'Canadian');
INSERT INTO author (name, age, nationality) VALUES ('Haruki Murakami', 75, 'Japanese');
INSERT INTO author (name, age, nationality) VALUES ('Yukio Mishima', 45, 'Japanese');
INSERT INTO author (name, age, nationality) VALUES ('Natsume Sōseki', 49, 'Japanese');
INSERT INTO author (name, age, nationality) VALUES ('Rabindranath Tagore', 80, 'Indian');
INSERT INTO author (name, age, nationality) VALUES ('Salman Rushdie', 77, 'British-Indian');
INSERT INTO author (name, age, nationality) VALUES ('Chinua Achebe', 82, 'Nigerian');
INSERT INTO author (name, age, nationality) VALUES ('Wole Soyinka', 90, 'Nigerian');
INSERT INTO author (name, age, nationality) VALUES ('Ngũgĩ wa Thiongo', 86, 'Kenyan');
INSERT INTO author (name, age, nationality) VALUES ('J.R.R. Tolkien', 81, 'English');
INSERT INTO author (name, age, nationality) VALUES ('C.S. Lewis', 64, 'British');
INSERT INTO author (name, age, nationality) VALUES ('Isaac Asimov', 72, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Arthur C. Clarke', 90, 'British');
INSERT INTO author (name, age, nationality) VALUES ('Ray Bradbury', 91, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Philip K. Dick', 53, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Ursula K. Le Guin', 88, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Kurt Vonnegut', 84, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Joseph Heller', 76, 'American');
INSERT INTO author (name, age, nationality) VALUES ('John Steinbeck', 66, 'American');
INSERT INTO author (name, age, nationality) VALUES ('William Faulkner', 64, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Flannery O''Connor', 39, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Truman Capote', 59, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Harper Lee', 89, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Cormac McCarthy', 89, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Don DeLillo', 88, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Thomas Pynchon', 87, 'American');
INSERT INTO author (name, age, nationality) VALUES ('David Foster Wallace', 46, 'American');
INSERT INTO author (name, age, nationality) VALUES ('Zadie Smith', 49, 'British');
INSERT INTO author (name, age, nationality) VALUES ('Chimamanda Ngozi Adichie', 47, 'Nigerian');
INSERT INTO author (name, age, nationality) VALUES ('Elena Ferrante', 55, 'Italian');
INSERT INTO author (name, age, nationality) VALUES ('Olga Tokarczuk', 62, 'Polish');

-- Insertion des Categories (20 catégories avec hiérarchie)
INSERT INTO category (category_name, parent_category) VALUES ('Literature', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Fiction', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Non-Fiction', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Science Fiction', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Fantasy', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Mystery', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Romance', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Historical Fiction', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Thriller', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Horror', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Biography', 3);
INSERT INTO category (category_name, parent_category) VALUES ('History', 3);
INSERT INTO category (category_name, parent_category) VALUES ('Philosophy', 3);
INSERT INTO category (category_name, parent_category) VALUES ('Poetry', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Drama', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Classic Literature', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Contemporary Fiction', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Young Adult', 2);
INSERT INTO category (category_name, parent_category) VALUES ('Children''s Literature', 1);
INSERT INTO category (category_name, parent_category) VALUES ('Essays', 3);


-- Insertion des Books (170 livres)
-- Victor Hugo (Author ID: 1)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Les Misérables', 1862, 'French', 1463, 1, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Notre-Dame de Paris', 1831, 'French', 512, 1, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Les Travailleurs de la mer', 1866, 'French', 488, 1, 16);

-- William Shakespeare (Author ID: 2)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Hamlet', 1603, 'English', 342, 2, 15);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Romeo and Juliet', 1597, 'English', 298, 2, 15);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Macbeth', 1606, 'English', 256, 2, 15);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Compound', 1609, 'English', 233, 2, 15);

-- Jane Austen (Author ID: 3)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Pride and Prejudice', 1813, 'English', 432, 3, 7);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Sense and Sensibility', 1811, 'English', 409, 3, 7);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Emma', 1815, 'English', 474, 3, 7);

-- Charles Dickens (Author ID: 4)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Great Expectations', 1861, 'English', 544, 4, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Tale of Two Cities', 1859, 'English', 489, 4, 8);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Oliver Twist', 1838, 'English', 608, 4, 16);

-- Mark Twain (Author ID: 5)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Adventures of Tom Sawyer', 1876, 'English', 274, 5, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Adventures of Huckleberry Finn', 1884, 'English', 366, 5, 16);

-- Ernest Hemingway (Author ID: 6)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Old Man and the Sea', 1952, 'English', 127, 6, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Farewell to Arms', 1929, 'English', 355, 6, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('For Whom the Bell Tolls', 1940, 'English', 471, 6, 8);

-- F. Scott Fitzgerald (Author ID: 7)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Great Gatsby', 1925, 'English', 180, 7, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Tender Is the Night', 1934, 'English', 317, 7, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('How to Kill a Witch', 1938, 'English', 455, 7, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Marriage at Sea ', 1940, 'English', 344, 7, 16);

-- George Orwell (Author ID: 8)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('1984', 1949, 'English', 328, 8, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Animal Farm', 1945, 'English', 112, 8, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Homage to Catalonia', 1938, 'English', 232, 8, 11);

-- J.K. Rowling (Author ID: 9)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Harry Potter and the Philosopher''s Stone', 1997, 'English', 223, 9, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Harry Potter and the Chamber of Secrets', 1998, 'English', 251, 9, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Harry Potter and the Prisoner of Azkaban', 1999, 'English', 317, 9, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Harry Potter and the Goblet of Fire', 2000, 'English', 636, 9, 5);

-- Stephen King (Author ID: 10)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Shining', 1977, 'English', 447, 10, 10);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('It', 1986, 'English', 1138, 10, 10);
INSERT INTO book (title, publication_year, language, nb_pages,author_ida, category_idc) VALUES ('The Stand', 1978, 'English', 823, 10, 10);
INSERT INTO book (title, publication_year, language, nb_pages,author_ida, category_idc) VALUES ('Misery', 1987, 'English', 320, 10, 9);

-- Agatha Christie (Author ID: 11)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Murder on the Orient Express', 1934, 'English', 256, 11, 6);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('And Then There Were None', 1939, 'English', 272, 11, 6);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Murder of Roger Ackroyd', 1926, 'English', 312, 11, 6);

-- Leo Tolstoy (Author ID: 12)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('War and Peace', 1869, 'Russian', 1225, 12, 8);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Anna Karenina', 1878, 'Russian', 864, 12, 16);
INSERT INTO book (title, publication_year, language, nb_pages,author_ida, category_idc) VALUES ('The Death of Ivan Ilyich', 1886, 'Russian', 92, 12, 16);

-- Fyodor Dostoevsky (Author ID: 13)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Crime and Punishment', 1866, 'Russian', 671, 13, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Brothers Karamazov', 1880, 'Russian', 796, 13, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Idiot', 1869, 'Russian', 656, 13, 16);

-- Gabriel García Márquez (Author ID: 14)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('One Hundred Years of Solitude', 1967, 'Spanish', 417, 14, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Love in the Time of Cholera', 1985, 'Spanish', 368, 14, 17);

-- Pablo Neruda (Author ID: 15)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Twenty Love Poems and a Song of Despair', 1924, 'Spanish', 96, 15, 14);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Canto General', 1950, 'Spanish', 500, 15, 14);

-- Jorge Luis Borges (Author ID: 16)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Ficciones', 1944, 'Spanish', 174, 16, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Aleph', 1949, 'Spanish', 210, 16, 17);

-- Albert Camus (Author ID: 17)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Stranger', 1942, 'French', 123, 17, 13);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Plague', 1947, 'French', 308, 17, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Myth of Sisyphus', 1942, 'French', 212, 17, 13);

-- Jean-Paul Sartre (Author ID: 18)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Nausea', 1938, 'French', 178, 18, 13);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Being and Nothingness', 1943, 'French', 638, 18, 13);

-- Simone de Beauvoir (Author ID: 19)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Second Sex', 1949, 'French', 832, 19, 13);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Mandarins', 1954, 'French', 610, 19, 17);

-- Marcel Proust (Author ID: 20)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('In Search of Lost Time', 1913, 'French', 4215, 20, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Great Big Beautiful Life', 1914, 'French', 2992, 20, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Fake Skating ', 1918, 'French', 809, 20, 16);

-- Franz Kafka (Author ID: 21)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Metamorphosis', 1915, 'German', 201, 21, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Trial', 1925, 'German', 255, 21, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Castle', 1926, 'German', 352, 21, 16);

-- James Joyce (Author ID: 22)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Ulysses', 1922, 'English', 732, 22, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Portrait of the Artist as a Young Man', 1916, 'English', 253, 22, 16);

-- Virginia Woolf (Author ID: 23)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Mrs Dalloway', 1925, 'English', 194, 23, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('To the Lighthouse', 1927, 'English', 209, 23, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Orlando', 1928, 'English', 228, 23, 5);

-- Oscar Wilde (Author ID: 24)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Picture of Dorian Gray', 1890, 'English', 254, 24, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Importance of Being Earnest', 1895, 'English', 76, 24, 15);

-- Emily Brontë (Author ID: 25)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Wuthering Heights', 1847, 'English', 416, 25, 7);

-- Charlotte Brontë (Author ID: 26)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Jane Eyre', 1847, 'English', 507, 26, 7);

-- Herman Melville (Author ID: 27)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Moby-Dick', 1851, 'English', 635, 27, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Billy Budd', 1924, 'English', 132, 27, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('About time', 1930, 'English', 222, 27, 16);

-- Edgar Allan Poe (Author ID: 28)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Raven and Other Poems', 1845, 'English', 98, 28, 14);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Tales of Mystery and Imagination', 1908, 'English', 356, 28, 10);

-- Nathaniel Hawthorne (Author ID: 29)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Scarlet Letter', 1850, 'English', 272, 29, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Stay with me ', 1855, 'English', 122, 29, 16);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('First summer', 1859, 'English', 455, 29, 16);

-- Ralph Waldo Emerson (Author ID: 30)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Essays: First Series', 1841, 'English', 312, 30, 20);

-- Henry David Thoreau (Author ID: 31)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Walden', 1854, 'English', 335, 31, 20);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Civil Disobedience', 1849, 'English', 48, 31, 20);

-- Walt Whitman (Author ID: 32)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Leaves of Grass', 1855, 'English', 147, 32, 14);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Onyx Storm ', 1865, 'English', 433, 32, 14);

-- Emily Dickinson (Author ID: 33)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Complete Poems', 1890, 'Arabic', 352, 33, 14);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('A Good Man Is Hard to Find', 2006, 'Arabic', 188, 33, 15);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Tha last night', 2023, 'Arabic', 409, 33, 17);


-- T.S. Eliot (Author ID: 34)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Waste Land', 1922, 'English', 64, 34, 14);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Four Quartets', 1943, 'English', 80, 34, 14);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Good things', 1990, 'English', 64, 34, 12);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The first day in paris', 2009, 'English', 199, 34, 9);

-- Ezra Pound (Author ID: 35)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Cantos', 1970, 'English', 824, 35, 14);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The black cat', 1978, 'English', 488, 35, 14);

-- Sylvia Plath (Author ID: 36)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('The Bell Jar', 1963, 'English', 244, 36, 17);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Ariel', 1965, 'English', 85, 36, 14);

-- Maya Angelou (Author ID: 37)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('I Know Why the Caged Bird Sings', 1969, 'English', 281, 37, 11);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Why me', 1999, 'English', 122, 37, 12);

-- Toni Morrison (Author ID: 38)
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Beloved', 1987, 'English', 324, 38, 17);
INSERT INTO book (title, publication_year, language, nb_pages,  author_ida, category_idc) VALUES ('Song of Solomon', 1977, 'English', 337, 38, 17);

-- Alice Walker (Author ID: 39)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Color Purple', 1982, 'English', 295, 39, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('leave', 1987, 'English', 265, 39, 17);

-- Margaret Atwood (Author ID: 40)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Handmaid''s Tale', 1985, 'English', 311, 40, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Oryx and Crake', 2003, 'English', 376, 40, 4);

-- Haruki Murakami (Author ID: 41)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Norwegian Wood', 1987, 'Japanese', 296, 41, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Kafka on the Shore', 2002, 'Japanese', 480, 41, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('1Q84', 2009, 'Japanese', 925, 41, 17);

-- Yukio Mishima (Author ID: 42)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Temple of the Golden Pavilion', 1956, 'Japanese', 262, 42, 16);

-- Natsume Sōseki (Author ID: 43)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Kokoro', 1914, 'Japanese', 256, 43, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Alice', 1920, 'Japanese', 766, 43, 16);

-- Rabindranath Tagore (Author ID: 44)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Gitanjali', 1910, 'Bengali', 157, 44, 14);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Life', 1919, 'Bengali', 176, 44, 14);

-- Salman Rushdie (Author ID: 45)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Midnight''s Children', 1981, 'English', 536, 45, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Satanic Verses', 1988, 'English', 561, 45, 17);

-- Chinua Achebe (Author ID: 46)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Things Fall Apart', 1958, 'English', 209, 46, 8);

-- Wole Soyinka (Author ID: 47)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Death and the King''s Horseman', 1975, 'English', 88, 47, 15);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Unworthy', 1989, 'English', 122, 47, 18);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Never Flinch', 1997, 'English', 490, 47, 19);

-- Ngũgĩ wa Thiongo (Author ID: 48)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('What is your name', 1959, 'English', 299, 48, 7);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Grain of Wheat', 1967, 'English', 280, 48, 8);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('What?', 1969, 'English', 377, 48, 8);

-- J.R.R. Tolkien (Author ID: 49)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Hobbit', 1937, 'English', 310, 49, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Lord of the Rings', 1954, 'English', 1178, 49, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Silmarillion', 1977, 'English', 365, 49, 5);

-- C.S. Lewis (Author ID: 50)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Lion, the Witch and the Wardrobe', 1950, 'English', 208, 50, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Chronicles of Narnia', 1956, 'English', 767, 50, 5);

-- Isaac Asimov (Author ID: 51)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Foundation', 1951, 'English', 255, 51, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('I, Robot', 1950, 'English', 224, 51, 4);

-- Arthur C. Clarke (Author ID: 52)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('2001: A Space Odyssey', 1968, 'English', 297, 52, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Rendezvous with Rama', 1973, 'English', 243, 52, 4);

-- Ray Bradbury (Author ID: 53)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Fahrenheit 451', 1953, 'English', 249, 53, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Martian Chronicles', 1950, 'English', 222, 53, 4);

-- Philip K. Dick (Author ID: 54)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Do Androids Dream of Electric Sheep?', 1968, 'English', 210, 54, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Man in the High Castle', 1962, 'English', 259, 54, 4);

-- Ursula K. Le Guin (Author ID: 55)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Left Hand of Darkness', 1969, 'English', 304, 55, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Wizard of Earthsea', 1968, 'English', 183, 55, 5);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Darkness', 1970, 'English', 199, 55, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Blood on Her Tongue', 1972, 'English', 307, 55, 5);
-- Kurt Vonnegut (Author ID: 56)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Slaughterhouse-Five', 1969, 'English', 275, 56, 4);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Cat''s Cradle', 1963, 'English', 304, 56, 4);

-- Joseph Heller (Author ID: 57)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Catch-22', 1961, 'English', 453, 57, 17);

-- John Steinbeck (Author ID: 58)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Grapes of Wrath', 1939, 'English', 464, 58, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Of Mice and Men', 1937, 'English', 107, 58, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('East of Eden', 1952, 'English', 601, 58, 16);

-- William Faulkner (Author ID: 59)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Sound and the Fury', 1929, 'English', 326, 59, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('As I Lay Dying', 1930, 'English', 267, 59, 16);

-- Flannery O'Connor (Author ID: 60)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('A Good Man Is Hard to Find', 1955, 'English', 251, 60, 17);

-- Truman Capote (Author ID: 61)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('In Cold Blood', 1966, 'English', 343, 61, 9);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Breakfast at Tiffany''s', 1958, 'English', 179, 61, 17);

-- Harper Lee (Author ID: 62)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('To Kill a Mockingbird', 1960, 'English', 324, 62, 16);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Kill Me', 1967, 'English', 388, 62, 16);


-- Cormac McCarthy (Author ID: 63)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Road', 2006, 'English', 287, 63, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Blood Meridian', 1985, 'English', 337, 63, 17);

-- Don DeLillo (Author ID: 64)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('White Noise', 1985, 'English', 326, 64, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Underworld', 1997, 'English', 827, 64, 17);

-- Thomas Pynchon (Author ID: 65)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Gravity''s Rainbow', 1973, 'English', 760, 65, 17);

-- David Foster Wallace (Author ID: 66)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Infinite Jest', 1996, 'English', 1079, 66, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Emmily', 1999, 'English', 200, 66, 4);


-- Zadie Smith (Author ID: 67)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('White Teeth', 2000, 'English', 448, 67, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('On Beauty', 2005, 'English', 445, 67, 17);

-- Chimamanda Ngozi Adichie (Author ID: 68)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Half of a Yellow Sun', 2006, 'English', 433, 68, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Americanah', 2013, 'English', 477, 68, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Stringer things', 2016, 'English', 791, 68, 16);

-- Elena Ferrante (Author ID: 69)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('My Brilliant Friend', 2011, 'Italian', 331, 69, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('The Story of a New Name', 2012, 'Italian', 471, 69, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Sorry', 2023, 'Italian', 200, 69, 7);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Friends', 1991, 'Italian', 681, 69, 12);


-- Olga Tokarczuk (Author ID: 70)
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Flights', 2007, 'Polish', 403, 70, 17);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Drive Your Plow Over the Bones of the Dead', 2009, 'Polish', 275, 70, 6);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Me befor you', 2002, 'Polish', 601, 70, 13);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('Merry Me', 2008, 'Polish', 200, 70,10);
INSERT INTO book (title, publication_year, language, nb_pages, author_ida, category_idc) VALUES ('My friends', 2010, 'Polish', 200, 70,10);
