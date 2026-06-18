<script lang="ts" module>
  import * as Dialog from '$lib/components/ui/dialog';
  import { Button } from '$lib/components/ui/button';
</script>

<script lang="ts">
  interface Props {
    title: string;
    description?: string;
    thumbnailUrl: string;
    thumbnailWideUrl: string;
    releaseYear?: number;
  }

  let { title, description, thumbnailUrl, thumbnailWideUrl, releaseYear }: Props = $props();
</script>

<Dialog.Root>
  <Dialog.Trigger
    class="cursor-pointer border hover:border-primary focus:border-primary focus:outline-none box-border transition-colors duration-200"
  >
    <div class="flex flex-col w-36 sm:w-48 shadow-sm overflow-hidden h-full text-left">
      <img src={thumbnailUrl} alt={title} class="w-full aspect-2/3 object-cover" />
      <div class="flex flex-col gap-1 p-2 h-full justify-between">
        <h3 class="font-bold leading-tight tracking-tighter line-clamp-2">{title}</h3>
        <p class="text-xs text-muted-foreground text-right leading-none tracking-tight">{releaseYear}</p>
      </div>
    </div>
  </Dialog.Trigger>

  <Dialog.Content class="min-w-full md:min-w-3xl">
    <Dialog.Header>
      <Dialog.Title class="pr-10 tracking-normal"
        >{title} <span class="text-xs text-muted-foreground">{releaseYear}</span></Dialog.Title
      >
    </Dialog.Header>

    <div class="flex flex-col md:flex-row gap-4">
      <img src={thumbnailUrl} alt={title} class="w-48 aspect-2/3 object-cover border hidden md:block" />
      <img
        src={thumbnailWideUrl}
        alt={title}
        class="w-full mx-auto max-w-xl aspect-video object-cover border block md:hidden"
      />
      <div class="flex flex-col gap-2 h-full justify-between">
        <p class="text-sm text-muted-foreground">{description}</p>
        <Button variant="default" class="w-fit">Watch</Button>
      </div>
    </div>
  </Dialog.Content>
</Dialog.Root>
