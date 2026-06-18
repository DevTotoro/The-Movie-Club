<script lang="ts">
  import MediaCard from '$lib/components/media-card.svelte';
</script>

<div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 xl:grid-cols-4 gap-4">
  <MediaCard
    title="The Dark Knight"
    thumbnailUrl="https://placehold.co/1000x1500/png/000000"
    thumbnailWideUrl="https://placehold.co/1600x900/png/000000"
    releaseYear={2008}
  />
  <MediaCard
    title="The Dark Knight Rises"
    description="The Dark Knight Rises is a 2012 American superhero film based on the DC Comics character Batman. It is the third installment in Christopher Nolan's Batman trilogy, following The Dark Knight and The Dark Knight Rises."
    thumbnailUrl="https://placehold.co/1000x1500/000000/png"
    thumbnailWideUrl="https://placehold.co/1600x900/000000/png"
    releaseYear={2012}
  />
  <MediaCard
    title="This is a very long title that should be truncated with a tooltip"
    thumbnailUrl="https://placehold.co/600x900/ffffff/png"
    thumbnailWideUrl="https://placehold.co/1600x900/ffffff/png"
  />
  <MediaCard
    title="This is a very long title that should be truncated with a tooltip"
    description="The Dark Knight Rises is a 2012 American superhero film based on the DC Comics character Batman. It is the third installment in Christopher Nolan's Batman trilogy, following The Dark Knight and The Dark Knight Rises."
    thumbnailUrl="https://placehold.co/600x900/png/000000"
    thumbnailWideUrl="https://placehold.co/1600x900/png/000000"
    releaseYear={2016}
  />
</div>
