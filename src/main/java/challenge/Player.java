package challenge;

public class Player {

    private String id;
    private String name;
    private String fullName;
    private String club;
    private String age;
    private String birthDate;
    private String nationality;
    private String eurWage;
    private String eurReleaseClause;


    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName( String fullName ) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge( String age ) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub( String club ) {
        this.club = club;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality( String nationality ) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate( String birthDate ) {
        this.birthDate = birthDate;
    }

    public String getEurReleaseClause() {
        return eurReleaseClause;
    }

    public void setEurReleaseClause( String eurReleaseClause ) {
        this.eurReleaseClause = eurReleaseClause;
    }

    public String getEurWage() {
        return eurWage;
    }

    public void setEurWage( String eurWage ) {
        this.eurWage = eurWage;
    }
}