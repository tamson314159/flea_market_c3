{\rtf1\ansi\ansicpg932\deff0\nouicompat\deflang1033\deflangfe1041{\fonttbl{\f0\fnil\fcharset128 \'82\'6c\'82\'72 \'96\'be\'92\'a9;}}
{\*\generator Riched20 10.0.22621}\viewkind4\uc1 
\pard\sa200\sl276\slmult1\f0\fs22\lang17 CREATE TABLE product(\par
product_id INTEGER PRIMARY KEY AUTO INCREMENT,\par
product_name VARCHAR(20) NOT NULL,\par
kinds VARCHAR(20) NOT NULL,\par
price INTEGER NOT NULL,\par
quantity INTEGER NOT NULL,\par
remarks TEXT,\par
region VARCHAR(20),\par
exhibition_date DATE NOT NULL,\par
update_date DATE NOT NULL,\par
image TEXT NOT NULL,\par
transaction VARCHAR(1) NOT NULL,\par
user_id INTEGER,\par
FOREIGN KEY (user_id) REFERENCES user_info(user_id) ON UPDATE CASCADE ON DELETE CASCADE\par

\pard )ENGINE=InnoDB;\par

\pard\sa200\sl276\slmult1\par
}
 