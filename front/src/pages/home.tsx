import Banner from "@/components/home/Banner";
import NavBar from "@/components/NavBar";
import SearchBar from "@/components/SearchBar";

export default function Home() {
  return (
    <>
      <NavBar />
      <SearchBar />
      <Banner />
      <div>This is Home Page</div>
    </>
  );
}
