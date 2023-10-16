create table faculty
(
    userId  text primary key,
    name text,
    gender text ,
    dob date,
    department text,
    contactNumber text,
    address text,
    designation text
);
create table socialLinks
(
    SocialId text primary key,
    UserId text not null,
    github text,
    linkedin text
);
create table recentEducation
(
    recentId text primary key,
    userId text not null,
    type text not null,
    issuedBy text not null
);
create table experience
(
    experienceId text primary key,
    userId  text not null,
    experienceType text not null,
    exFrom date,
    exTo date,
    company text,
    designation text
);